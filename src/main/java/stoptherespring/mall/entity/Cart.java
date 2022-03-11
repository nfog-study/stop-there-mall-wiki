package stoptherespring.mall.entity;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shipping_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@OneToOne(fetch = LAZY)
	@JoinColumn(name = "product_id")
	private Product productId;

	private Long quantity;
}
