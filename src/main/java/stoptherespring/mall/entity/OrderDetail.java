package stoptherespring.mall.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "ORDER_DETAIL")
public class OrderDetail {
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_ID")
	private Orders order;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	private Long orderQuantity;
	private Long price;
}
