package org.example.homepagembti2024.repository;

import org.example.homepagembti2024.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query("SELECT n, w FROM Notice n LEFT JOIN n.writer w WHERE " +
            "(:type = 't' AND n.title LIKE %:keyword%) OR " +
            "(:type = 'c' AND n.content LIKE %:keyword%) OR " +
            "(:type = 'w' AND w.name LIKE %:keyword%) OR " +
            "(:type = 'tc' AND (n.title LIKE %:keyword% OR n.content LIKE %:keyword%)) OR " +
            "(:type = 'tcw' AND (n.title LIKE %:keyword% OR n.content LIKE %:keyword% OR w.name LIKE %:keyword%)) OR " +
            "(:type IS NULL AND (n.title LIKE %:keyword% OR n.content LIKE %:keyword% OR w.name LIKE %:keyword%))")
    Page<Object[]> searchNotices(@Param("type") String type, @Param("keyword") String keyword, Pageable pageable);

    @Query("SELECT n, w FROM Notice n LEFT JOIN n.writer w WHERE n.bno = :bno")
    Object getNoticeByBno(@Param("bno") Long bno);

    @Query("SELECT n, w FROM Notice n LEFT JOIN n.writer w")
    Page<Object[]> getNoticeWithWriter(Pageable pageable);
}
