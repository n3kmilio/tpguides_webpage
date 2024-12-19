package tpguides.repository;

import tpguides.model.Guide;

public interface GuideRepository {
    Guide findByName(String name);
}
