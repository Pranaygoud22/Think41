package com.pranay.EcommerceChatbotApplication.Repository;

import com.pranay.EcommerceChatbotApplication.Model.DistributionCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistributionRepo extends JpaRepository<DistributionCenter,Long> {
}
