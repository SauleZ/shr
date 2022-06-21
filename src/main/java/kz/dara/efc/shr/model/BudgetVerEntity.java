package kz.dara.efc.shr.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.Hibernate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.dara.efc.shr.util.JpaBooleanConverter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(schema = "nsi", name = "nsi_dict_budget_ver")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BudgetVerEntity {

    @Id
    private Long id;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_kz")
    private String nameKz;

    @Column(name = "short_name_ru")
    private String shortNameRu;

    @Column(name = "short_name_kz")
    private String shortNameKz;
    
    @ManyToOne
    @JoinColumn(name = "budget_type_id")
    private BudgetType budgetType;
    
    @ManyToOne
    @JoinColumn(name = "budget_request_type_id")
    private BudgetRequestTypeEntity requestType;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    @JsonIgnore
    private BudgetVerStatusEntity status; // HERE
    
    @ManyToOne
    @JoinColumn(name = "begin_year_id")
    private FinYearEntity beginFinYear;
    
    @ManyToOne
    @JoinColumn(name = "end_year_id")
    private FinYearEntity endFinYear;
    
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    private Date beginDate;
    
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @JsonIgnore
    @Basic(fetch = FetchType.LAZY)
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", updatable = false)
    @ToString.Exclude
    protected Date createDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update_date")
    protected Date updateDate;
    
    @ManyToOne
    @JoinColumn(name = "create_by")
    private User createdBy;
    
    @ManyToOne
    @JoinColumn(name = "last_update_by")
    private User updatedBy;
    
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private BudgetVerEntity parent;
    
    @Column(name = "is_ebk")
    @Convert(converter = JpaBooleanConverter.class)
    private Boolean isEbk;
    
    @Column(name = "is_income")
    @Convert(converter = JpaBooleanConverter.class)
    private Boolean isIncome;
    
    private String blocked;
    
    @Column(name = "order_number")
    private Long orderNumber;
    
    @Column(name = "last_update_by")
    @JsonIgnore
    protected Long lastUpdateBy;
    
    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        final BudgetVerEntity that = (BudgetVerEntity) o;
        return id != null && Objects.equals(id, that.id);
    }
    
    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
