package com.springboot.api.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = 1940741074L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> number = createNumber("number", Long.class);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final ListPath<Producer, QProducer> producers = this.<Producer, QProducer>createList("producers", Producer.class, QProducer.class, PathInits.DIRECT2);

    public final QProductDetail productDetail;

    public final QProvider provider;

    public final NumberPath<Integer> stock = createNumber("stock", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.productDetail = inits.isInitialized("productDetail") ? new QProductDetail(forProperty("productDetail"), inits.get("productDetail")) : null;
        this.provider = inits.isInitialized("provider") ? new QProvider(forProperty("provider")) : null;
    }

}

