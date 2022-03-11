package stoptherespring.mall.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import stoptherespring.mall.entity.enums.OrderStatus;

@Entity
@Getter
@Table(name = "ORDERS")
@EntityListeners(AuditingEntityListener.class)
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUYER_ID")
	private Member buyer;

	@OneToMany(mappedBy = "order")
	private List<OrderDetail> details = new ArrayList<>();

	@Column(name = "ORDER_DATE")
	private LocalDateTime date;

	@Enumerated(EnumType.STRING)
	@Column(name = "ORDER_STATUS")
	private OrderStatus status;
}
