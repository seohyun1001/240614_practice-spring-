package org.zerock.springbackendproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zerock.springbackendproject.Entity.Board;
import org.zerock.springbackendproject.exception.BoardNotFoundException;
import org.zerock.springbackendproject.repository.BoardRepository;
import org.zerock.springbackendproject.service.BoardService;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:3000")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @PostMapping("/registerBoard")
    public Board register(@RequestBody Board newBoard) {
        return boardRepository.save(newBoard);
    }

    @GetMapping("/boardList")
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    @GetMapping("/board/{bno}")
    public Optional<Board> getBoardByBno(@PathVariable Long bno) {
        return boardService.getBoardById(bno);
    }

    @PutMapping("/board/{bno}")
    Board updateBoard(@RequestBody Board updateBoard, @PathVariable Long bno) {
        return boardRepository.findById(bno)
                .map(board -> {
                    board.setTitle(updateBoard.getTitle());
                    board.setContent(updateBoard.getContent());
                    return boardRepository.save(board);
                }).orElseThrow(() ->new BoardNotFoundException(bno));
    }

    @DeleteMapping("/board/{bno}")
    String deleteUser(@PathVariable Long bno) {
        if(!boardRepository.existsById(bno)) {
            throw new BoardNotFoundException(bno);
        }
        boardRepository.deleteById(bno);
        return "게시물 번호 : " +bno+"번은 삭제 되었습니다";
    }


}
