package com.pranay.EcommerceChatbotApplication.Repository;

import com.pranay.EcommerceChatbotApplication.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users,Long> {
}
