package com.codegym.demo.repository;

import com.codegym.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "SELECT * FROM blog WHERE `title` LIKE :titleSearch AND category_id LIKE :categoryId",
            countQuery = "SELECT * FROM blog WHERE `title` LIKE :titleSearch AND category_id LIKE :categoryId",
            nativeQuery = true)
    Page<Blog> findByTitleAndCategory(@Param("titleSearch") String titleSearch, @Param("categoryId") String categoryIdSearch, Pageable pageable);
}
