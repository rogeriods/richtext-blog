package br.com.rds.blog.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.rds.blog.models.Post;

public interface PostRepository extends CrudRepository<Post, Long> {

}
