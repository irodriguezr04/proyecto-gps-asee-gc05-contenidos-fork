package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Subscription
 */

@JsonTypeName("subscription")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-03T18:02:44.513930+01:00[Europe/Madrid]", comments = "Generator version: 7.17.0")
public class Subscription {

  private @Nullable String userId;

  private @Nullable String artistId;

  private @Nullable String createdAt;

  public Subscription userId(@Nullable String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   */
  
  @Schema(name = "user_id", example = "usr_777", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("user_id")
  public @Nullable String getUserId() {
    return userId;
  }

  public void setUserId(@Nullable String userId) {
    this.userId = userId;
  }

  public Subscription artistId(@Nullable String artistId) {
    this.artistId = artistId;
    return this;
  }

  /**
   * Get artistId
   * @return artistId
   */
  
  @Schema(name = "artist_id", example = "art_001", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("artist_id")
  public @Nullable String getArtistId() {
    return artistId;
  }

  public void setArtistId(@Nullable String artistId) {
    this.artistId = artistId;
  }

  public Subscription createdAt(@Nullable String createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
   */
  
  @Schema(name = "created_at", example = "2025-10-15T18:00:00Z", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("created_at")
  public @Nullable String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(@Nullable String createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subscription subscription = (Subscription) o;
    return Objects.equals(this.userId, subscription.userId) &&
        Objects.equals(this.artistId, subscription.artistId) &&
        Objects.equals(this.createdAt, subscription.createdAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, artistId, createdAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subscription {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    artistId: ").append(toIndentedString(artistId)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

