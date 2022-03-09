package kms.dat.zego.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kms.dat.zego.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
}
