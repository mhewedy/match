package match.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mysema.query.types.Predicate;

import lombok.Getter;
import match.beans.User;
import match.beans.repos.UserRepo;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
public class AdminController extends CrudController<User, UserRepo> {

	@Getter
	@Autowired
	private UserRepo repository;

	@Override
	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public ResponseEntity<User> get(@PathVariable("id") Long id) {
		return super.get(id);
	}

	@Override
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody @Valid User user) {
		return super.save(user);
	}

	@Override
	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid User user) {
		return super.update(id, user);
	}

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<User>> query(Predicate predicate, Pageable pageable) {
		return super.query(predicate, pageable);
	}
}
