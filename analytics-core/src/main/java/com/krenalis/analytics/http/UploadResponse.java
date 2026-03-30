package com.krenalis.analytics.http;

import com.google.auto.value.AutoValue;
import com.krenalis.analytics.gson.AutoGson;

@AutoValue
@AutoGson
public abstract class UploadResponse {
  public abstract boolean success();
}
