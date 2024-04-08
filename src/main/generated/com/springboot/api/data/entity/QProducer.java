package com.springboot.api.data.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProducer is a Querydsl query type for Producer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProducer extends EntityPathBase<Producer> {

    private static final long serialVersionUID = 33430799L;

    public static final QProducer producer = new QProducer("producer");

    public final StringPath code = createString("code");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<Product, QProduct> products = this.<Product, QProduct>createList("products", Product.class, QProduct.class, PathInits.DIRECT2);

    public QProducer(String variable) {
        super(Producer.class, forVariable(variable));
    }

    public QProducer(Path<? extends Producer> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProducer(PathMetadata metadata) {
        super(Producer.class, metadata);
    }

}

