package ABCBankService.com.group.bestvision.yrm.test.repository;

import ABCBankService.com.group.bestvision.yrm.test.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<PhoneEntity, Long>, JpaSpecificationExecutor<PhoneEntity>
{

}
