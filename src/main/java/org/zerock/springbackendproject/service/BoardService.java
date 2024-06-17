package org.zerock.springbackendproject.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.springbackendproject.Entity.Board;
import org.zerock.springbackendproject.repository.BoardRepository;

import java.util.Optional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private final BoardRepository boardRepository;

    public Optional<Board> getBoardById(Long bno) {
        increaseHit(bno);
        return boardRepository.findById(bno);
    }

    public Board increaseHit(Long bno) {
        return boardRepository.findById(bno)
                .map(board -> {
                    board.setHit(board.getHit() + 1);
                    return boardRepository.save(board);
                })
                .orElse(null);
    }

}
