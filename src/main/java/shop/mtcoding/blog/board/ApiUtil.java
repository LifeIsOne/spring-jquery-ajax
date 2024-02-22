package shop.mtcoding.blog.board;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiUtil<T> {
    private Integer status; // 200, 400
    private String msg;     // 성공, 실패시 정확한 메시지
    private T body;         // 제네릭을 쓴다. Object는 왜?

    public ApiUtil(T body) {
        this.status = 200;
        this.msg = "성공";
        this.body = body;
    }

    public ApiUtil(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
        this.body = null;
    }

}
