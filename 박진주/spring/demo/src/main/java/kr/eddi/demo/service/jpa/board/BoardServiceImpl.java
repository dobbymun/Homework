package kr.eddi.demo.service.jpa.board;

import kr.eddi.demo.controller.jpa.board.request.BoardRequest;
import kr.eddi.demo.entity.jpa.boards.Board;
import kr.eddi.demo.repository.board.BoardRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {               // BoardServiceImpl(자식)는 BoardService(부모)의 구현체를 담은 것
    /*
    extends/implements/abstract 차이점

     (1) extends: 부모에서 선언 / 정의를 모두하며 자식은 메소드 / 변수를 그대로 사용할 수 있음
     (2) implements(interface 구현): 부모 객체는 선언만 하며 정의(내용)은 자식에서 오버라이딩 (재정의) 해서 사용해야함
     (3) abstract: extends와 interface 혼합. extends하되 몇 개는 추상 메소드로 구현되어 있음

     */


    @Autowired
    BoardRepository repository;   // BoardRepository는 extends JPARepository<Board, Long> 되어 있음

    @Override
    public void register(BoardRequest boardRequest) {
        Board board = new Board();
        board.setTitle(boardRequest.getTitle());
        board.setContent(boardRequest.getContent());
        board.setWriter(boardRequest.getWriter());

        repository.save(board);
    }

    @Override
    public List<Board> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public Board read(Long boardNo) {
        //findById 사용할 때는 Optional 사용 -> 객체가 Board 아닐 가능성도 있기때문에
        Optional<Board> maybeBoard = repository.findById(boardNo);

        if (maybeBoard.equals(Optional.empty())) {
            log.info("Can't read board!!!");
            return null;
        }

        return maybeBoard.get();
    }


    @Override
    public void modify(Board board) {
        repository.save(board);
    }

    @Override
    public void remove(Long boardNo) {
        repository.deleteById(boardNo);
    }
}