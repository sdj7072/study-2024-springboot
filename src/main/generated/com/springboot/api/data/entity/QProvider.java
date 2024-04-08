package com.springboot.api.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProvider is a Querydsl query type for Provider
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProvider extends EntityPathBase<Provider> {

    private static final long serialVersionUID = 49697646L;

    public static final QProvider provider = new QProvider("provider");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<Product, QProduct> productList = this.<Product, QProduct>createList("productList", Product.class, QProduct.class, PathInits.DIRECT2);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QProvider(String variable) {
        super(Provider.class, forVariable(variable));
    }

    public QProvider(Path<? extends Provider> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProvider(PathMetadata metadata) {
        super(Provider.class, metadata);
    }

}

