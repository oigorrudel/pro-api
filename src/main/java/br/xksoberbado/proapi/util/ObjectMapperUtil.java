package br.xksoberbado.proapi.util;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;

@Component
public class ObjectMapperUtil {

    private static final ModelMapper MODEL_MAPPER;

    static {
        MODEL_MAPPER = new ModelMapper();
    }

    public <I, O> O map(final I object, final Class<O> clazz) {
        return MODEL_MAPPER.map(object, clazz);
    }

    public <I, O> Function<I, O> mapFn(final Class<O> clazz) {
        return object -> MODEL_MAPPER.map(object, clazz);
    }

    public <I, O> List<O> mapAll(final Collection<I> objectList, final Class<O> clazz) {
        return objectList.stream()
            .map(object -> MODEL_MAPPER.map(object, clazz))
            .toList();
    }

    public <I, O> Function<List<I>, List<O>> mapAllFn(final Class<O> clazz) {
        return objectList -> objectList.stream()
            .map(object -> MODEL_MAPPER.map(object, clazz))
            .toList();
    }
}
