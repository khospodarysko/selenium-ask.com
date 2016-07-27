package com.lohika.block;

/**
 * General interface that describes the result item found on result page after search is done.
 * Each search item could be of a different type. Such result type are already implemented:
 * <ul>
 *     <li>{@link DictionaryResult}</li>
 *     <li>{@link NewsResult}</li>
 *     <li>{@link SimpleResult}</li>
 * </ul>
 */
public interface Result {
    String getLink();
    String getTitle();
    String getDescription();
}
