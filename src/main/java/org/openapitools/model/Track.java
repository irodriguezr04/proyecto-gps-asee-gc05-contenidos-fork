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
 * Track
 */

@JsonTypeName("track")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-03T18:02:44.513930+01:00[Europe/Madrid]", comments = "Generator version: 7.17.0")
public class Track {

  private @Nullable String id;

  private @Nullable String albumId;

  private @Nullable String title;

  private @Nullable String duration;

  private @Nullable String fileUrl;

  private @Nullable String publishedAt;

  public Track id(@Nullable String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", example = "trk_301", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable String getId() {
    return id;
  }

  public void setId(@Nullable String id) {
    this.id = id;
  }

  public Track albumId(@Nullable String albumId) {
    this.albumId = albumId;
    return this;
  }

  /**
   * Get albumId
   * @return albumId
   */
  
  @Schema(name = "album_id", example = "alb_101", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("album_id")
  public @Nullable String getAlbumId() {
    return albumId;
  }

  public void setAlbumId(@Nullable String albumId) {
    this.albumId = albumId;
  }

  public Track title(@Nullable String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  
  @Schema(name = "title", example = "De acero", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("title")
  public @Nullable String getTitle() {
    return title;
  }

  public void setTitle(@Nullable String title) {
    this.title = title;
  }

  public Track duration(@Nullable String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Get duration
   * @return duration
   */
  
  @Schema(name = "duration", example = "03:45", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("duration")
  public @Nullable String getDuration() {
    return duration;
  }

  public void setDuration(@Nullable String duration) {
    this.duration = duration;
  }

  public Track fileUrl(@Nullable String fileUrl) {
    this.fileUrl = fileUrl;
    return this;
  }

  /**
   * Get fileUrl
   * @return fileUrl
   */
  
  @Schema(name = "file_url", example = "https://cdn.musica.com/tracks/de-acero.mp3", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("file_url")
  public @Nullable String getFileUrl() {
    return fileUrl;
  }

  public void setFileUrl(@Nullable String fileUrl) {
    this.fileUrl = fileUrl;
  }

  public Track publishedAt(@Nullable String publishedAt) {
    this.publishedAt = publishedAt;
    return this;
  }

  /**
   * Get publishedAt
   * @return publishedAt
   */
  
  @Schema(name = "published_at", example = "2025-10-16T20:00:00Z", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("published_at")
  public @Nullable String getPublishedAt() {
    return publishedAt;
  }

  public void setPublishedAt(@Nullable String publishedAt) {
    this.publishedAt = publishedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Track track = (Track) o;
    return Objects.equals(this.id, track.id) &&
        Objects.equals(this.albumId, track.albumId) &&
        Objects.equals(this.title, track.title) &&
        Objects.equals(this.duration, track.duration) &&
        Objects.equals(this.fileUrl, track.fileUrl) &&
        Objects.equals(this.publishedAt, track.publishedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, albumId, title, duration, fileUrl, publishedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Track {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    albumId: ").append(toIndentedString(albumId)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    fileUrl: ").append(toIndentedString(fileUrl)).append("\n");
    sb.append("    publishedAt: ").append(toIndentedString(publishedAt)).append("\n");
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

