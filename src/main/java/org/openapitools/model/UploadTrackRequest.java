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
 * UploadTrackRequest
 */

@JsonTypeName("uploadTrack_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-03T18:02:44.513930+01:00[Europe/Madrid]", comments = "Generator version: 7.17.0")
public class UploadTrackRequest {

  private String title;

  private String duration;

  private String fileUrl;

  @JsonProperty("genre")
  private String genre;

  public UploadTrackRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UploadTrackRequest(String title, String duration, String fileUrl, String genre) {
    this.title = title;
    this.duration = duration;
    this.fileUrl = fileUrl;
    this.genre = genre;
  }

  public UploadTrackRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  @NotNull 
  @Schema(name = "title", example = "De acero", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public UploadTrackRequest duration(String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Get duration
   * @return duration
   */
  @NotNull 
  @Schema(name = "duration", example = "03:45", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("duration")
  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public UploadTrackRequest fileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
    return this;
  }

  /**
   * Get fileUrl
   * @return fileUrl
   */
  @NotNull 
  @Schema(name = "file_url", example = "https://cdn.musica.com/tracks/de-acero.mp3", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("file_url")
  public String getFileUrl() {
    return fileUrl;
  }

  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
  }

  public UploadTrackRequest genre(String genre) {
    this.genre = genre;
    return this;
  }
  /**
   * Get genre
   * @return genre
   */
  @NotNull
  @Schema(name = "genre", example = "Rock", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("genre")
  public String getGenre() {
    return genre;
  }
  public void setGenre(String genre) {
    this.genre = genre;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadTrackRequest uploadTrackRequest = (UploadTrackRequest) o;
    return Objects.equals(this.title, uploadTrackRequest.title) &&
        Objects.equals(this.duration, uploadTrackRequest.duration) &&
        Objects.equals(this.fileUrl, uploadTrackRequest.fileUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, duration, fileUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadTrackRequest {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    duration: ").append(toIndentedString(duration)).append("\n");
    sb.append("    fileUrl: ").append(toIndentedString(fileUrl)).append("\n");
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

