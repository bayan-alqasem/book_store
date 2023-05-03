package jo.jordan.JordanBookStore.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrinciple implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;

	public UserPrinciple(User user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		  List<GrantedAuthority> authorities = new ArrayList<>();
//	        this.user.getAuthorities().forEach(p -> {
//	            GrantedAuthority authority = new SimpleGrantedAuthority(p.getAuthoritiesName());
//	            authorities.add(authority);
//	        });
		  List<String> auth=
		  this.user.getRoles().stream().map(Role::getRoleName).collect(Collectors.toList());
//	        this.user.getRoles().forEach(p -> {
//	            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + p.getRoleName());
//	            authorities.add(authority);
//	        });
	        return auth.stream().map(SimpleGrantedAuthority::new ).collect(Collectors.toList());
		
	
	}

	@Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.user.getActive() == 1;
	}

}
