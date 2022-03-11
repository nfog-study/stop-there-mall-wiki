package stoptherespring.mall.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "review_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private Product postId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "writer_id")
	private Member writer;

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdDate;

	private String title;
	private String body;
	private Long score;
}
