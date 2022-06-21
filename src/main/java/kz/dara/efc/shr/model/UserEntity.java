package kz.dara.efc.shr.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(schema = "auth", name = "auth_user")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserEntity {
	@Id
	private Long id;
	
	@Column(name = "iin")
	private String iin;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "patronymic")
	private String patronymic;
	
	@Column(name = "bin")
	private String bin;
	
	@Column(name = "is_director")
	private Boolean isDirector;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "is_root")
	private Boolean isRoot;
	
	@Column(name = "is_archive")
	private Boolean isArchive;
	
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "update_date")
	private Date updateDate;
	
	@ManyToOne
	@JoinColumn(name = "org_struct_id")
	private OrgStruct orgStruct;
	
	private Set<Role> userRoles = new HashSet<>();
	private Set<UserDict> userDicts = new HashSet<>();
}
