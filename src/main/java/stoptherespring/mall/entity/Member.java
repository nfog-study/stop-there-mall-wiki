package stoptherespring.mall.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import stoptherespring.mall.entity.enums.ExistStatus;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "MEMBER")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_id")
	private Long id;

	@Column(unique = true)
	private String email;

	private String phoneNumber;

	private String password;

	private String nickname;

	private String name;

	@Embedded
	private Address address;

	private Long point;

	@Enumerated(EnumType.STRING)
	private ExistStatus existStatus;

	@OneToMany(mappedBy = "member")
	private List<Cart> cart = new ArrayList<>();

	@OneToMany(mappedBy = "writer")
	private List<Post> posts = new ArrayList<>();

	@OneToMany(mappedBy = "seller")
	private List<Product> products = new ArrayList<>();

	@OneToMany(mappedBy = "writer")
	private List<Review> reviews = new ArrayList<>();

	@OneToMany(mappedBy = "buyer")
	private List<Orders> orders = new ArrayList<>();
}
