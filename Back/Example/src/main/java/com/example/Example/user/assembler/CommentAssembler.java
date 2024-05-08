package com.example.Example.user.assembler;

import com.example.Example.user.model.Comment;
import com.example.Example.user.model.CommentDto;
import org.springframework.stereotype.Component;
@Component
public class CommentAssembler {

    public CommentDto map(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setText(comment.getText());
        return dto;
    }

    public Comment update(CommentDto dto) {
        Comment comment = new Comment();
        comment.setText(dto.getText());
        return comment;
    }
}


