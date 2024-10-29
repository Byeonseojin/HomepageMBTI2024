package org.example.homepagembti2024.repository;


import org.example.homepagembti2024.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

}
