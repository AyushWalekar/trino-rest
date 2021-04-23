/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package pl.net.was.rest.github.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pull
{
    private final long id;
    private final String url;
    private final String htmlUrl;
    private final String diffUrl;
    private final String patchUrl;
    private final String issueUrl;
    private final String commitsUrl;
    private final String reviewCommentsUrl;
    private final String reviewCommentUrl;
    private final String commentsUrl;
    private final String statusesUrl;
    private final long number;
    private final String state;
    private final Boolean locked;
    private final String title;
    private final User user;
    private final String body;
    private final List<Label> labels;
    private final Milestone milestone;
    private final String activeLockReason;
    private final ZonedDateTime createdAt;
    private final ZonedDateTime updatedAt;
    private final ZonedDateTime closedAt;
    private final ZonedDateTime mergedAt;
    private final String mergedCommitSha;
    private final User assignee;
    private final List<User> requestedReviewers;
    private final String headRef;
    private final String headSha;
    private final String baseRef;
    private final String baseSha;
    private final String authorAssociation;
    private final Boolean draft;

    public Pull(
            @JsonProperty("id") long id,
            @JsonProperty("url") String url,
            @JsonProperty("html_url") String htmlUrl,
            @JsonProperty("diff_url") String diffUrl,
            @JsonProperty("patch_url") String patchUrl,
            @JsonProperty("issue_url") String issueUrl,
            @JsonProperty("commits_url") String commitsUrl,
            @JsonProperty("review_comments_url") String reviewCommentsUrl,
            @JsonProperty("review_comment_url") String reviewCommentUrl,
            @JsonProperty("comments_url") String commentsUrl,
            @JsonProperty("statuses_url") String statusesUrl,
            @JsonProperty("number") long number,
            @JsonProperty("state") String state,
            @JsonProperty("locked") Boolean locked,
            @JsonProperty("title") String title,
            @JsonProperty("user") User user,
            @JsonProperty("body") String body,
            @JsonProperty("labels") List<Label> labels,
            @JsonProperty("milestone") Milestone milestone,
            @JsonProperty("active_lock_reason") String activeLockReason,
            @JsonProperty("created_at") ZonedDateTime createdAt,
            @JsonProperty("updated_at") ZonedDateTime updatedAt,
            @JsonProperty("closed_at") ZonedDateTime closedAt,
            @JsonProperty("merged_at") ZonedDateTime mergedAt,
            @JsonProperty("merged_commit_sha") String mergedCommitSha,
            @JsonProperty("assignee") User assignee,
            @JsonProperty("requested_reviewers") List<User> requestedReviewers,
            @JsonProperty("head") Ref head,
            @JsonProperty("base") Ref base,
            @JsonProperty("author_association") String authorAssociation,
            @JsonProperty("draft") Boolean draft)
    {
        this.id = id;
        this.url = url;
        this.htmlUrl = htmlUrl;
        this.diffUrl = diffUrl;
        this.patchUrl = patchUrl;
        this.issueUrl = issueUrl;
        this.commitsUrl = commitsUrl;
        this.reviewCommentsUrl = reviewCommentsUrl;
        this.reviewCommentUrl = reviewCommentUrl;
        this.commentsUrl = commentsUrl;
        this.statusesUrl = statusesUrl;
        this.number = number;
        this.state = state;
        this.locked = locked;
        this.title = title;
        this.user = user;
        this.body = body;
        this.labels = labels;
        this.milestone = milestone;
        this.activeLockReason = activeLockReason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.closedAt = closedAt;
        this.mergedAt = mergedAt;
        this.mergedCommitSha = mergedCommitSha;
        this.assignee = assignee;
        this.requestedReviewers = requestedReviewers;
        this.headRef = head.getRef();
        this.headSha = head.getSha();
        this.baseRef = base.getRef();
        this.baseSha = base.getSha();
        this.authorAssociation = authorAssociation;
        this.draft = draft;
    }

    public List<?> toRow()
    {
        return ImmutableList.of(
                id,
                url,
                htmlUrl,
                diffUrl,
                patchUrl,
                issueUrl,
                commitsUrl,
                reviewCommentsUrl,
                reviewCommentUrl,
                commentsUrl,
                statusesUrl,
                number,
                state,
                locked,
                title,
                user.getId(),
                user.getLogin(),
                body,
                labels.stream().map(Label::getId).collect(Collectors.toList()),
                labels.stream().map(Label::getName).collect(Collectors.toList()),
                milestone.getId(),
                milestone.getTitle(),
                activeLockReason,
                createdAt,
                updatedAt,
                closedAt,
                mergedAt,
                mergedCommitSha,
                assignee.getId(),
                assignee.getLogin(),
                requestedReviewers.stream().map(User::getId).collect(Collectors.toList()),
                requestedReviewers.stream().map(User::getLogin).collect(Collectors.toList()),
                headRef,
                headSha,
                baseRef,
                baseSha,
                authorAssociation,
                draft);
    }
}
