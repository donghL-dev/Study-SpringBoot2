package com.donghun.repository;

import com.donghun.domain.Board;
import com.donghun.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
    Page<Board> findAllByOrderByIdxDesc(Pageable pageable);
}
