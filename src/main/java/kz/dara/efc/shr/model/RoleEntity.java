package kz.dara.efc.shr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(schema = "auth", name = "auth_role")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class RoleEntity {
	
	@Id
	private String role;
	
	@Column(name = "module")
	private Module module;
	
	@Column(name = "role_type")
	private String roleType;
	
	@Column(name = "name_ru")
	private String nameRu;
	
	@Column(name = "name_kz")
	private String nameKz;
	
	@Column(name = "name_kz")
	private String nameKz;
}
