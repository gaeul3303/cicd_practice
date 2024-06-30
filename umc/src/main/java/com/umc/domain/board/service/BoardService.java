package com.umc.domain.board.service;

import com.umc.common.response.ApiResponse;
import com.umc.domain.board.dto.BoardRequestDTO;
import com.umc.domain.board.dto.BoardResponseDTO;
import com.umc.domain.board.entity.Board;
import com.umc.domain.board.repository.BoardRepository;
import com.umc.domain.user.entity.Member;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public ApiResponse<BoardResponseDTO> createBoard(BoardRequestDTO request){
        Board board=new Board();
        board.setTitle(request.getTitle());
        board.setPostNum(request.getPostNum());
        boardRepository.save(board);
        return BoardResponseDTO(board);
    }


    @Transactional
    public Long updateBoard(Long board_id, BoardRequestDTO request) {
        Board board = BoardRepository.findById(board_id).orElseThrow(() -> new IllegalArgumentException("해당 게시판이 없습니다. id=" + board_id));
        board.updateBoard(BoardResponseDTO.getTitle());
        return board_id;
    }

    @Transactional(readOnly = true)
    public List<BoardResponseDTO> getBoard() {
        return boardRepository.findAllByOrderByUpdatedAtDesc().stream().map(BoardResponseDTO::new).toList();
    }
}
