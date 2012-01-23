package com.kline.booking.service;

import java.util.List;

import com.kline.booking.entity.BkgNote;
import com.kline.core.service.BaseIdEntityService;

public interface BkgNoteService extends BaseIdEntityService {

	public List<BkgNote> findMyBkgNote(long bkgMasterId);
}
