package com.melaniedura.hiltplayground.framework.datasource.cache.mappers

import com.melaniedura.hiltplayground.business.domain.models.Blog
import com.melaniedura.hiltplayground.business.domain.util.EntityMapper
import com.melaniedura.hiltplayground.framework.datasource.cache.model.BlogCacheEntity
import javax.inject.Inject

class CacheMapper
@Inject
constructor(): EntityMapper<BlogCacheEntity, Blog> {

    override fun mapFromEntity(entity: BlogCacheEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category
        )
    }

}