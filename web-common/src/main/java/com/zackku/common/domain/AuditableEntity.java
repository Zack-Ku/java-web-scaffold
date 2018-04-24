package com.zackku.common.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Zack
 * @date 2018/4/24
 */
public interface AuditableEntity<T extends AuditableEntity<T, ID>, ID extends Serializable> extends Entity<T, ID> {
    /**
     * Returns the user who created this entity.
     *
     * @return the createdBy
     */
    String getCreatedBy();

    /**
     * Sets the user who created this entity.
     *
     * @param createdBy the creating entity to set
     */
    void setCreatedBy(final String createdBy);

    /**
     * Returns the creation date of the entity.
     *
     * @return the createdDate
     */
    Date getCreatedDate();

    /**
     * Sets the creation date of the entity.
     *
     * @param createdDate the creation date to set
     */
    void setCreatedDate(final Date createdDate);

    /**
     * Returns the user who modified the entity lastly.
     *
     * @return the lastModifiedBy
     */
    String getLastModifiedBy();

    /**
     * Sets the user who modified the entity lastly.
     *
     * @param lastModifiedBy the last modifying entity to set
     */
    void setLastModifiedBy(final String lastModifiedBy);

    /**
     * Returns the date of the last modification.
     *
     * @return the lastModifiedDate
     */
    Date getLastModifiedDate();

    /**
     * Sets the date of the last modification.
     *
     * @param lastModifiedDate the date of the last modification to set
     */
    void setLastModifiedDate(final Date lastModifiedDate);
}