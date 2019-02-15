## 여러 형태의 게시판 출력

### 1. 페이징 형식 출력

  * BoardService 클래스 수정

    ```java
    public Page<Board> findBoardList(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber() <=0 ? 0 : pageable.getPageNumber()-1, pageable.getPageSize());
        return boardRepository.findAll(pageable);
    }
    ```

  * 결과 확인

    ![default](https://user-images.githubusercontent.com/33312179/52828864-dfc3d580-310d-11e9-9b20-a1e24b5eaa89.png)


### 2. 페이징 형식 역순 출력

  * BoardService 클래스 수정

    ```java
    public Page<Board> findBoardList(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber() <=0 ? 0 : pageable.getPageNumber()-1, pageable.getPageSize());
        return boardRepository.findAllByOrderByIdxDesc(pageable);
    }
    ```

  * BoardRepository 인터페이스 수정

    ```java
    public interface BoardRepository extends JpaRepository<Board, Long>{
        Board findByUser(User user);
        Page<Board> findAllByOrderByIdxDesc(Pageable pageable);
    }
    ```

  * 결과 확인

    ![default](https://user-images.githubusercontent.com/33312179/52828881-f79b5980-310d-11e9-916a-10be6940cc36.png)


### 3. 리스트 출력

  * BoardService 클래스 수정

    ```java
    public List<Board> findBoardList(){
        return boardRepository.findAll();
    }
    ```

  * BoardController 수정

    ```java
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("boardList", boardService.findBoardList());
        return "/board/list";
    }
    ```

  * 결과 확인

    ![default](https://user-images.githubusercontent.com/33312179/52828892-fe29d100-310d-11e9-8ce8-bc2a547a4311.png)


### 4. 리스트 형식 역순 출력

  * BoardService 클래스 수정

    ```java
    public Page<Board> findBoardList(){
        return boardRepository.findAllByOrderByIdxDesc();
    }
    ```

  * BoardRepository 인터페이스 수정

    ```java
    public interface BoardRepository extends JpaRepository<Board, Long>{
        Board findByUser(User user);
        List<Board> findAllByOrderByIdxDesc();
    }
    ```

  * 결과 확인

    ![default](https://user-images.githubusercontent.com/33312179/52828898-02ee8500-310e-11e9-9e47-cd08c4cbaf78.png)



