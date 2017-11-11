package od.city.claims.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Represents claim that should be processed by government
 */
@Entity
public class Claim extends DomainObject {

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String description;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date creationDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}



