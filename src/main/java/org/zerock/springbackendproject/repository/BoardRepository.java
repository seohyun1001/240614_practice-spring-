package org.zerock.springbackendproject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.springbackendproject.Entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
