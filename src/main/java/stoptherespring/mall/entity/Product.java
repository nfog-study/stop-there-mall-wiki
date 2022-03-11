package stoptherespring.mall.entity;

import static javax.persistence.FetchType.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "seller_id")
	private Member seller;

	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime createdDate;

	@Column(name = "PRODUCT_NAME")
	private String name;

	private Long stockQuantity;

	private Long price;

	@OneToMany(mappedBy = "postId")
	private List<Review> reviews = new ArrayList<>();

	@OneToMany(mappedBy = "product")
	private List<OrderDetail> orderDetails = new ArrayList<>();
}
