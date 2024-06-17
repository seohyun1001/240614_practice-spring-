package org.zerock.springbackendproject.exception;

public class BoardNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BoardNotFoundException(Long bno) {
        super("id에 맞는 유저가 없습니다." + bno);
    }
}
