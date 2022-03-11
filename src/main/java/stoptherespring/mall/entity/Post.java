package stoptherespring.mall.entity;

import static javax.persistence.FetchType.*;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import stoptherespring.mall.entity.enums.ExistStatus;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "post_id")
	private Long id;

	@OneToOne(fetch = LAZY)
	@JoinColumn(name = "product_id")
	private Product product;

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdDate;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "writer_id")
	private Member writer;

	private String title;
	private String body;

	@Enumerated(EnumType.STRING)
	private ExistStatus existStatus;
}
