package kr.eddi.demo.repository.board;

import kr.eddi.demo.entity.jpa.boards.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {  // 스프링에서 제공하는 JpaRepository 를 포함(extends)한다고 적어주면 JpaRepository에서 제공하는 메소드 등 사용 가능

    /**
     JpaRepository 인터페이스는 org.springframework.data.jpa.repository 패키지의 "JpaRepository"라는 인터페이스를 상속하여 만든다.
     JpaRepository <>안에는 엔티티 클래스 이름과 ID 필드 타입이 지정된다.
     주의할 점은 "기본형의 경우, 래퍼 클래스를 지정한다는 점이다.
     여기서 Board 클래스는 long 형을 ID (boardNo)를 지정하고 있기 때문에, 여기에서는 <Board, Long>라고 작성한다.
     */


}