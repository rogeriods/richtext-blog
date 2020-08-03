package br.com.rds.blog.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.rds.blog.models.Post;
import br.com.rds.blog.repository.PostRepository;

@Controller
public class PostController {

	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/")
	public String getAllPosts(Model model) {
		model.addAttribute("posts", postRepository.findAll());
		return "index";
	}
	
	@GetMapping("/post/new")
	public String newPost(Model model) {
		model.addAttribute("post", new Post());
		return "postform";
	}
	
	@PostMapping("/post")
	public String createPost(Post post, Model model) {
		postRepository.save(post);
		return "redirect:/";
	}
	
	@GetMapping("/post/edit/{id}")
	public String editPost(@PathVariable Long id, Model model) {
		model.addAttribute("post", postRepository.findById(id).orElse(new Post()));
		return "postform";
	}
	
	@GetMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Long id) {
		postRepository.deleteById(id);
        return "redirect:/";
    }
	
}
