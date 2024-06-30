package com.umc.domain.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDTO {
    Long CommentId;
    LocalDateTime created_at;
    LocalDateTime updated_at;
    Long MemberId;
    Long BoardId;
    Long PostId;
}
