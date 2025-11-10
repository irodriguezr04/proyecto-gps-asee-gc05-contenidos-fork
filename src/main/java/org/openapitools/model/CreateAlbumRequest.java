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
 * CreateAlbumRequest
 */

@JsonTypeName("createAlbum_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-03T18:02:44.513930+01:00[Europe/Madrid]", comments = "Generator version: 7.17.0")
public class CreateAlbumRequest {

  private String title;

  private String releaseDate;

  private String coverUrl;

  public CreateAlbumRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateAlbumRequest(String title, String releaseDate, String coverUrl) {
    this.title = title;
    this.releaseDate = releaseDate;
    this.coverUrl = coverUrl;
  }

  public CreateAlbumRequest title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   */
  @NotNull 
  @Schema(name = "title", example = "La ley innata", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public CreateAlbumRequest releaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
    return this;
  }

  /**
   * Get releaseDate
   * @return releaseDate
   */
  @NotNull 
  @Schema(name = "release_date", example = "2008-09-09", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("release_date")
  public String getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(String releaseDate) {
    this.releaseDate = releaseDate;
  }

  public CreateAlbumRequest coverUrl(String coverUrl) {
    this.coverUrl = coverUrl;
    return this;
  }

  /**
   * Get coverUrl
   * @return coverUrl
   */
  @NotNull 
  @Schema(name = "cover_url", example = "https://avatar.iran.liara.run/public/40", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cover_url")
  public String getCoverUrl() {
    return coverUrl;
  }

  public void setCoverUrl(String coverUrl) {
    this.coverUrl = coverUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateAlbumRequest createAlbumRequest = (CreateAlbumRequest) o;
    return Objects.equals(this.title, createAlbumRequest.title) &&
        Objects.equals(this.releaseDate, createAlbumRequest.releaseDate) &&
        Objects.equals(this.coverUrl, createAlbumRequest.coverUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, releaseDate, coverUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateAlbumRequest {\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    releaseDate: ").append(toIndentedString(releaseDate)).append("\n");
    sb.append("    coverUrl: ").append(toIndentedString(coverUrl)).append("\n");
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

