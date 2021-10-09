package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "SELECT " +
            "        MEMBER_ID," +
            "        ACCOUNT_TX_ID,"+
            "        ACCOUNT_TYPE_ID,"+
            "        MILES_AMOUNT," +
            "        MEMBER_START_DATE" +
            "    FROM " +
            "        DISCOVERY.DISCOVERY_MEMBER " +
            "   WHERE MEMBER_ID = :memberId", nativeQuery = true)
    Member getMemberByMemberIdNativeQuery(String memberId);

    @Query(value = "SELECT " +
            "        m" +
            "    FROM " +
            "       Member m" +
            "   WHERE m.memberId = :memberId ")
    Member getMemberByMemberId(String memberId);


    @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.MemberDto( " +
            "        m.memberId,"+
            "        m.milesAmount,"+
            "        m.memberStartDate ) "+
            "    FROM " +
            "        Member m" +
            "   WHERE m.memberId = :memberId ")
    MemberDto getMemberDtoByMemberId(String memberId);
}
