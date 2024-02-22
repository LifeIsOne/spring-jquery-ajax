package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//  ajax 통신을 위한 Controller
@RestController
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardRepository boardRepository;

    @PostMapping("/api/boards")
    public ApiUtil<?> write(@RequestBody BoardRequest.WriteDTO requestDTO){
        boardRepository.insert(requestDTO);
        return new ApiUtil<>(null);
    }

    @DeleteMapping("/api/boards/{id}")
    public ApiUtil<?> deleteById(@PathVariable Integer id){
        Board board = boardRepository.selectOne(id);
        if (board ==null){
            return new ApiUtil<>(404,"해당 게시글을 찾을 수 없습니다.");
        }
        boardRepository.deleteById(id);
        return new ApiUtil<>(null);
    }


    @GetMapping("/api/boards")  // 복수형을 많이 쓴다. 보드'들'줘~
    public ApiUtil<List<Board>>findAll(HttpServletResponse response){
        //  response.setStatus(400);    // 강제 터트리기
        List<Board> boardList = boardRepository.selectAll();
        return new ApiUtil<>(boardList);
    }
}