package service

/**
 * Created by FScoward on 15/08/13.
 */

/*
import argonaut.Argonaut._
import argonaut.DecodeJson
case class RealTimeMessagingJson(
                                ok: String
                                ,url: String
                                ,self: Self
                                ,team: Team
                                ,latest_event_ts: String
                                ,channels: List[Channel]
                                ,groups: List[Group]
                                ,ims: List[Im]
                                ,cache_ts: Int
                                ,users: List[User]
                                ,cache_version: String
                                ,bots: List[Bot]
                                  )
object RealTimeMessagingJson {
  implicit def RealTimeMessagingJsonDecodeJson: DecodeJson[RealTimeMessagingJson] = DecodeJson.derive[RealTimeMessagingJson]
}


case class Bot(
              id: String
              ,name: String
              ,deleted: Boolean
              ,icons: List[Icon]
                )
object Bot {
  implicit def BotDecodeJson: DecodeJson[Bot] = DecodeJson.derive[Bot]
}

case class User(
               id: String
               ,name: String
               ,deleted: Boolean
               ,status: String
               ,color: String
               ,real_name: String
               ,tz: String
               ,tz_label: String
               ,tz_offset: Int
               ,profile: UserProfile
               ,has_files: Boolean
               ,is_admin: Boolean
               ,is_owner: Boolean
               ,is_primary_owner: Boolean
               ,is_restricted: Boolean
               ,is_ultra_restricted: Boolean
               ,is_bot: Boolean
               ,has_2fa: Boolean
               ,presence: String
                 )
object User {
  implicit def UserDecodeJson: DecodeJson[User] = DecodeJson.derive[User]
}


case class UserProfile(
                      real_name: String
                      ,real_name_normalized: String
                      ,email: String
                      ,image_24: String
                      ,image_32: String
                      ,image_48: String
                      ,image_72: String
                      ,image_192: String
                        )
object UserProfile {
  implicit def UserProfileDecodeJson: DecodeJson[UserProfile] = DecodeJson.derive[UserProfile]
}
case class Im(
             id: String
             ,is_im: Boolean
             ,user: String
             ,created: Int
             ,last_read: String
             ,latest: Latest
             ,unread_count: Int
            ,unread_count_display: Int
            ,is_open: Boolean
               )
object Im {
  implicit def ImDecodeJson: DecodeJson[Im] = DecodeJson.derive[Im]
}

case class Group(
                id: String
                ,name: String
                ,is_group: Boolean
                ,created: Int
                ,creator: String
                ,is_archived: Boolean
                ,has_pins: Boolean
                ,is_open: Boolean
                ,last_read: String
                ,latest: Latest
                ,unread_count: Int
                ,unread_count_display: Int
                ,members: List[String]
                ,topic: Topic
                ,purpose: Purpose
                  )
object Group {
  implicit def GroupDecodeJson: DecodeJson[Group] = DecodeJson.derive[Group]
}

case class Channel(
                   id: String
                   ,name: String
                  ,is_channel: Boolean
                  ,created: Int
                  ,creator: String
                  ,is_archived: Boolean
                  ,is_general: Boolean
                  ,has_pins: Boolean
                  ,is_member: Boolean
                  ,last_read: String
                  ,latest: Latest
                  ,unread_count: Int
                  ,unread_count_display: Int
                  ,members: List[String]
                  ,topic: Topic
                  ,purpose: Purpose
               )
object Channel {
  implicit def ChannelDecodeJson: DecodeJson[Channel] = DecodeJson.derive[Channel]
}
case class Purpose(
                  value: String
                  ,creator: String
                  ,last_set: String
                    )
object Purpose {
  implicit def PurposeDecodeJson: DecodeJson[Purpose] = DecodeJson.derive[Purpose]
}
case class Topic(
                value: String
                ,creator: String
                ,last_set: Int
                  )
object Topic {
  implicit def TopicDecodeJson: DecodeJson[Topic] = DecodeJson.derive[Topic]
}
case class Latest(
                 text: String
                 ,username: String
                 ,`type`: String
                 ,subtype: String
                 ,ts: String
                   )
object Latest {
  implicit def LatestDecodeJson: DecodeJson[Latest] = DecodeJson.derive[Latest]
}


case class Icon(
             image_34: String
            ,image_44: String
            ,image_68: String
            ,image_88: String
            ,image_102: String
            ,image_132: String
            ,image_default: Boolean
                 )
object Icon {
  implicit def IconDecodeJson: DecodeJson[Icon] = DecodeJson.derive[Icon]
}


case class Team(
               id: String
               ,name: String
               ,email_domain: String
               ,msg_edit_window_mins: Int
               ,prefs: TeamPrefs
               ,icon: Icon
               ,over_storage_limit: Boolean
               ,plain: String
               ,profile: Profile
                 )
object Team {
  implicit def TeamDecodeJson: DecodeJson[Team] = DecodeJson.derive[Team]
}


case class Profile(fields: List[String])
object Profile {
  implicit def ProfileDecodeJson: DecodeJson[Profile] = DecodeJson.derive[Profile]
}

case class TeamPrefs(
                    default_channels: List[String]
                    ,msg_edit_window_mins: Int
                    ,allow_message_deletion: Boolean
                    ,hide_referers: Boolean
                    ,display_real_names: Boolean
                    ,who_can_at_everyone: String
                    ,who_can_at_channel: String
                    ,warn_before_at_channel: String
                    ,who_can_create_channels: String
                    ,who_can_archive_channels: String
                    ,who_can_create_groups: String
                    ,who_can_post_general: String
                    ,who_can_kick_channels: String
                    ,who_can_kick_groups: String
                    ,retention_type: Int
                    ,retention_duration: Int
                    ,group_retention_type: Int
                    ,group_retention_duration: Int
                    ,dm_retention_type: Int
                    ,dm_retention_duration: Int
                    ,file_retention_type: Int
                    ,file_retention_duration: Int
                    ,require_at_for_mention: Int
                    ,compliance_export_start: Int
                    ,auth_mode: String
                      )
object TeamPrefs {
//  implicit def TeamPrefsDecodeJson: DecodeJson[TeamPrefs] = DecodeJson.derive[TeamPrefs]
  implicit def TeamPrefsDecodeJson: DecodeJson[TeamPrefs] = DecodeJson(c => for {
    default_channels<-(c --\ "default_channels").as[ List[String]]
    msg_edit_window_mins<-(c --\ "msg_edit_window_mins").as[ Int]
    allow_message_deletion<-(c --\ "allow_message_deletion").as[ Boolean]
    hide_referers<-(c --\ "hide_referers").as[ Boolean]
    display_real_names<-(c --\ "display_real_names").as[ Boolean]
    who_can_at_everyone<-(c --\ "who_can_at_everyone").as[ String]
    who_can_at_channel<-(c --\ "who_can_at_channel").as[ String]
    warn_before_at_channel<-(c --\ "warn_before_at_channel").as[ String]
    who_can_create_channels<-(c --\ "who_can_create_channels").as[ String]
    who_can_archive_channels<-(c --\ "who_can_archive_channels").as[ String]
    who_can_create_groups<-(c --\ "who_can_create_groups").as[ String]
    who_can_post_general<-(c --\ "who_can_post_general").as[ String]
    who_can_kick_channels<-(c --\ "who_can_kick_channels").as[ String]
    who_can_kick_groups<-(c --\ "who_can_kick_groups").as[ String]
    retention_type<-(c --\ "retention_type").as[ Int]
    retention_duration<-(c --\ "retention_duration").as[ Int]
    group_retention_type<-(c --\ "group_retention_type").as[ Int]
    group_retention_duration<-(c --\ "group_retention_duration").as[ Int]
    dm_retention_type<-(c --\ "dm_retention_type").as[ Int]
    dm_retention_duration<-(c --\ "dm_retention_duration").as[ Int]
    file_retention_type<-(c --\ "file_retention_type").as[ Int]
    file_retention_duration<-(c --\ "file_retention_duration").as[ Int]
    require_at_for_mention<-(c --\ "require_at_for_mention").as[ Int]
    compliance_export_start<-(c --\ "compliance_export_start").as[ Int]
    auth_mode<-(c --\ "auth_mode").as[ String]
  }yield TeamPrefs(
    default_channels,
    msg_edit_window_mins,
    allow_message_deletion,
    hide_referers,
    display_real_names,
    who_can_at_everyone,
    who_can_at_channel,
    warn_before_at_channel,
    who_can_create_channels,
    who_can_archive_channels,
    who_can_create_groups,
    who_can_post_general,
    who_can_kick_channels,
    who_can_kick_groups,
    retention_type,
    retention_duration,
    group_retention_type,
    group_retention_duration,
    dm_retention_type,
    dm_retention_duration,
    file_retention_type,
    file_retention_duration,
    require_at_for_mention,
    compliance_export_start,
    auth_mode
  ))
}

case class Self(
               id: String
               ,name: String
               ,prefs: SelfPrefs
               ,created: String
               ,manual_presence: String
                 )
object Self {
  implicit def SelfDecodeJson: DecodeJson[Self] = DecodeJson.derive[Self]
}

case class SelfPrefs(
                highlight_words: String
                ,user_colors: String
                ,color_names_in_list: Boolean
                ,growls_enabled: Boolean
                ,tz: String
                ,push_dm_alert: Boolean
                ,push_mention_alert: Boolean
                ,push_everything: Boolean
                ,push_idle_wait: Int
                ,push_sound: String
                ,push_loud_channels: String
                ,push_mention_channels: String
                ,push_loud_channels_set: String
                ,email_alerts: String
                ,email_alerts_sleep_until: Int
                ,email_misc: Boolean
                ,email_weekly: Boolean
                ,welcome_message_hidden: Boolean
                ,all_channels_loud: Boolean
                ,loud_channels: String
                ,never_channels: String
                ,loud_channels_set: String
                ,show_member_presence: Boolean
                ,search_sort: String
                ,expand_inline_imgs: Boolean
                ,expand_internal_inline_imgs: Boolean
                ,expand_snippets: Boolean
                ,posts_formatting_guide: Boolean
                ,seen_welcome_2: Boolean
                ,seen_ssb_prompt: Boolean
                ,seen_spaces_new_xp_tooltip: Boolean
                ,spaces_new_xp_banner_dismissed: Boolean
                ,search_only_my_channels: Boolean
                ,emoji_mode: String
                ,emoji_use: String
                ,has_invited: Boolean
                ,has_uploaded: Boolean
                ,has_created_channel: Boolean
                ,search_exclude_channels: String
                ,messages_theme: String
                ,webapp_spellcheck: Boolean
                ,no_joined_overlays: Boolean
                ,no_created_overlays: Boolean
                ,dropbox_enabled: Boolean
                ,seen_domain_invite_reminder: Boolean
                ,seen_member_invite_reminder: Boolean
                ,mute_sounds: Boolean
                ,arrow_history: Boolean
                ,tab_ui_return_selects: Boolean
                ,obey_inline_img_limit: Boolean
                ,new_msg_snd: String
                ,collapsible: Boolean
                ,collapsible_by_click: Boolean
                ,require_at: Boolean
                ,ssb_space_window: String
                ,mac_ssb_bounce: String
                ,mac_ssb_bullet: Boolean
                ,expand_non_media_attachments: Boolean
                ,show_typing: Boolean
                ,pagekeys_handled: Boolean
                ,last_snippet_type: String
                ,display_real_names_override: Int
                ,time24: Boolean
                ,enter_is_special_in_tbt: Boolean
                ,graphic_emoticons: Boolean
                ,convert_emoticons: Boolean
                ,autoplay_chat_sounds: Boolean
                ,ss_emojis: Boolean
                ,sidebar_behavior: String
                ,seen_onboarding_start: Boolean
                ,onboarding_cancelled: Boolean
                ,seen_onboarding_slackbot_conversation: Boolean
                ,seen_onboarding_channels: Boolean
                ,seen_onboarding_direct_messages: Boolean
                ,seen_onboarding_invites: Boolean
                ,seen_onboarding_search: Boolean
                ,seen_onboarding_recent_mentions: Boolean
                ,seen_onboarding_starred_items: Boolean
                ,seen_onboarding_private_groups: Boolean
                ,onboarding_slackbot_conversation_step: Int
                ,mark_msgs_read_immediately: Boolean
                ,start_scroll_at_oldest: Boolean
                ,snippet_editor_wrap_long_lines: Boolean
                ,ls_disabled: Boolean
                ,sidebar_theme: String
                ,sidebar_theme_custom_values: String
                ,f_key_search: Boolean
                ,k_key_omnibox: Boolean
                ,speak_growls: Boolean
                ,mac_speak_voice: String
                ,mac_speak_speed: Int
                ,comma_key_prefs: Boolean
                ,at_channel_suppressed_channels: String
                ,push_at_channel_suppressed_channels: String
                ,prompted_for_email_disabling: Boolean
                ,full_text_extracts: Boolean
                ,no_text_in_notifications: Boolean
                ,muted_channels: String
                ,no_macssb1_banner: Boolean
                ,no_winssb1_banner: Boolean
                ,no_omnibox_in_channels: Boolean
                ,k_key_omnibox_auto_hide_count: Int
                ,privacy_policy_seen: Boolean
                ,search_exclude_bots: Boolean
                ,fuzzy_matching: Boolean
                ,load_lato_2: Boolean
                ,fuller_timestamps: Boolean
                ,last_seen_at_channel_warning: Int
                ,flex_resize_window: Boolean
                ,msg_preview: Boolean
                ,msg_preview_displaces: Boolean
                ,msg_preview_persistent: Boolean
                ,emoji_autocomplete_big: Boolean
                ,winssb_run_from_tray: Boolean
                ,two_factor_auth_enabled: Boolean
                ,two_factor_type: String //null (object)
                ,mentions_exclude_at_channels: Boolean
                ,confirm_clear_all_unreads: Boolean
                ,confirm_user_marked_away: Boolean
                ,box_enabled: Boolean
                ,seen_single_emoji_msg: Boolean
                ,confirm_sh_call_start: Boolean
                  )

object SelfPrefs {
//  implicit def SelfPrefsDecodeJson: DecodeJson[SelfPrefs] = DecodeJson.derive[SelfPrefs]
  implicit def SelfPrefsDecodeJson: DecodeJson[SelfPrefs] = DecodeJson(c => for{
 highlight_words<-(c --\ "highlight_words").as[ String]
user_colors<-(c --\ "user_colors").as[ String]
color_names_in_list<-(c --\ "color_names_in_list").as[ Boolean]
growls_enabled<-(c --\ "growls_enabled").as[ Boolean]
tz<-(c --\ "tz").as[ String]
push_dm_alert<-(c --\ "push_dm_alert").as[ Boolean]
push_mention_alert<-(c --\ "push_mention_alert").as[ Boolean]
push_everything<-(c --\ "push_everything").as[ Boolean]
push_idle_wait<-(c --\ "push_idle_wait").as[ Int]
push_sound<-(c --\ "push_sound").as[ String]
push_loud_channels<-(c --\ "push_loud_channels").as[ String]
push_mention_channels<-(c --\ "push_mention_channels").as[ String]
push_loud_channels_set<-(c --\ "push_loud_channels_set").as[ String]
email_alerts<-(c --\ "email_alerts").as[ String]
email_alerts_sleep_until<-(c --\ "email_alerts_sleep_until").as[ Int]
email_misc<-(c --\ "email_misc").as[ Boolean]
email_weekly<-(c --\ "email_weekly").as[ Boolean]
welcome_message_hidden<-(c --\ "welcome_message_hidden").as[ Boolean]
all_channels_loud<-(c --\ "all_channels_loud").as[ Boolean]
loud_channels<-(c --\ "loud_channels").as[ String]
never_channels<-(c --\ "never_channels").as[ String]
loud_channels_set<-(c --\ "loud_channels_set").as[ String]
show_member_presence<-(c --\ "show_member_presence").as[ Boolean]
search_sort<-(c --\ "search_sort").as[ String]
expand_inline_imgs<-(c --\ "expand_inline_imgs").as[ Boolean]
expand_internal_inline_imgs<-(c --\ "expand_internal_inline_imgs").as[ Boolean]
expand_snippets<-(c --\ "expand_snippets").as[ Boolean]
posts_formatting_guide<-(c --\ "posts_formatting_guide").as[ Boolean]
seen_welcome_2<-(c --\ "seen_welcome_2").as[ Boolean]
seen_ssb_prompt<-(c --\ "seen_ssb_prompt").as[ Boolean]
seen_spaces_new_xp_tooltip<-(c --\ "seen_spaces_new_xp_tooltip").as[ Boolean]
spaces_new_xp_banner_dismissed<-(c --\ "spaces_new_xp_banner_dismissed").as[ Boolean]
search_only_my_channels<-(c --\ "search_only_my_channels").as[ Boolean]
emoji_mode<-(c --\ "emoji_mode").as[ String]
emoji_use<-(c --\ "emoji_use").as[ String]
has_invited<-(c --\ "has_invited").as[ Boolean]
has_uploaded<-(c --\ "has_uploaded").as[ Boolean]
has_created_channel<-(c --\ "has_created_channel").as[ Boolean]
search_exclude_channels<-(c --\ "search_exclude_channels").as[ String]
messages_theme<-(c --\ "messages_theme").as[ String]
webapp_spellcheck<-(c --\ "webapp_spellcheck").as[ Boolean]
no_joined_overlays<-(c --\ "no_joined_overlays").as[ Boolean]
no_created_overlays<-(c --\ "no_created_overlays").as[ Boolean]
dropbox_enabled<-(c --\ "dropbox_enabled").as[ Boolean]
seen_domain_invite_reminder<-(c --\ "seen_domain_invite_reminder").as[ Boolean]
seen_member_invite_reminder<-(c --\ "seen_member_invite_reminder").as[ Boolean]
mute_sounds<-(c --\ "mute_sounds").as[ Boolean]
arrow_history<-(c --\ "arrow_history").as[ Boolean]
tab_ui_return_selects<-(c --\ "tab_ui_return_selects").as[ Boolean]
obey_inline_img_limit<-(c --\ "obey_inline_img_limit").as[ Boolean]
new_msg_snd<-(c --\ "new_msg_snd").as[ String]
collapsible<-(c --\ "collapsible").as[ Boolean]
collapsible_by_click<-(c --\ "collapsible_by_click").as[ Boolean]
require_at<-(c --\ "require_at").as[ Boolean]
ssb_space_window<-(c --\ "ssb_space_window").as[ String]
mac_ssb_bounce<-(c --\ "mac_ssb_bounce").as[ String]
mac_ssb_bullet<-(c --\ "mac_ssb_bullet").as[ Boolean]
expand_non_media_attachments<-(c --\ "expand_non_media_attachments").as[ Boolean]
show_typing<-(c --\ "show_typing").as[ Boolean]
pagekeys_handled<-(c --\ "pagekeys_handled").as[ Boolean]
last_snippet_type<-(c --\ "last_snippet_type").as[ String]
display_real_names_override<-(c --\ "display_real_names_override").as[ Int]
time24<-(c --\ "time24").as[ Boolean]
enter_is_special_in_tbt<-(c --\ "enter_is_special_in_tbt").as[ Boolean]
graphic_emoticons<-(c --\ "graphic_emoticons").as[ Boolean]
convert_emoticons<-(c --\ "convert_emoticons").as[ Boolean]
autoplay_chat_sounds<-(c --\ "autoplay_chat_sounds").as[ Boolean]
ss_emojis<-(c --\ "ss_emojis").as[ Boolean]
sidebar_behavior<-(c --\ "sidebar_behavior").as[ String]
seen_onboarding_start<-(c --\ "seen_onboarding_start").as[ Boolean]
onboarding_cancelled<-(c --\ "onboarding_cancelled").as[ Boolean]
seen_onboarding_slackbot_conversation<-(c --\ "seen_onboarding_slackbot_conversation").as[ Boolean]
seen_onboarding_channels<-(c --\ "seen_onboarding_channels").as[ Boolean]
seen_onboarding_direct_messages<-(c --\ "seen_onboarding_direct_messages").as[ Boolean]
seen_onboarding_invites<-(c --\ "seen_onboarding_invites").as[ Boolean]
seen_onboarding_search<-(c --\ "seen_onboarding_search").as[ Boolean]
seen_onboarding_recent_mentions<-(c --\ "seen_onboarding_recent_mentions").as[ Boolean]
seen_onboarding_starred_items<-(c --\ "seen_onboarding_starred_items").as[ Boolean]
seen_onboarding_private_groups<-(c --\ "seen_onboarding_private_groups").as[ Boolean]
onboarding_slackbot_conversation_step<-(c --\ "onboarding_slackbot_conversation_step").as[ Int]
mark_msgs_read_immediately<-(c --\ "mark_msgs_read_immediately").as[ Boolean]
start_scroll_at_oldest<-(c --\ "start_scroll_at_oldest").as[ Boolean]
snippet_editor_wrap_long_lines<-(c --\ "snippet_editor_wrap_long_lines").as[ Boolean]
ls_disabled<-(c --\ "ls_disabled").as[ Boolean]
sidebar_theme<-(c --\ "sidebar_theme").as[ String]
sidebar_theme_custom_values<-(c --\ "sidebar_theme_custom_values").as[ String]
f_key_search<-(c --\ "f_key_search").as[ Boolean]
k_key_omnibox<-(c --\ "k_key_omnibox").as[ Boolean]
speak_growls<-(c --\ "speak_growls").as[ Boolean]
mac_speak_voice<-(c --\ "mac_speak_voice").as[ String]
mac_speak_speed<-(c --\ "mac_speak_speed").as[ Int]
comma_key_prefs<-(c --\ "comma_key_prefs").as[ Boolean]
at_channel_suppressed_channels<-(c --\ "at_channel_suppressed_channels").as[ String]
push_at_channel_suppressed_channels<-(c --\ "push_at_channel_suppressed_channels").as[ String]
prompted_for_email_disabling<-(c --\ "prompted_for_email_disabling").as[ Boolean]
full_text_extracts<-(c --\ "full_text_extracts").as[ Boolean]
no_text_in_notifications<-(c --\ "no_text_in_notifications").as[ Boolean]
muted_channels<-(c --\ "muted_channels").as[ String]
no_macssb1_banner<-(c --\ "no_macssb1_banner").as[ Boolean]
no_winssb1_banner<-(c --\ "no_winssb1_banner").as[ Boolean]
no_omnibox_in_channels<-(c --\ "no_omnibox_in_channels").as[ Boolean]
k_key_omnibox_auto_hide_count<-(c --\ "k_key_omnibox_auto_hide_count").as[ Int]
privacy_policy_seen<-(c --\ "privacy_policy_seen").as[ Boolean]
search_exclude_bots<-(c --\ "search_exclude_bots").as[ Boolean]
fuzzy_matching<-(c --\ "fuzzy_matching").as[ Boolean]
load_lato_2<-(c --\ "load_lato_2").as[ Boolean]
fuller_timestamps<-(c --\ "fuller_timestamps").as[ Boolean]
last_seen_at_channel_warning<-(c --\ "last_seen_at_channel_warning").as[ Int]
flex_resize_window<-(c --\ "flex_resize_window").as[ Boolean]
msg_preview<-(c --\ "msg_preview").as[ Boolean]
msg_preview_displaces<-(c --\ "msg_preview_displaces").as[ Boolean]
msg_preview_persistent<-(c --\ "msg_preview_persistent").as[ Boolean]
emoji_autocomplete_big<-(c --\ "emoji_autocomplete_big").as[ Boolean]
winssb_run_from_tray<-(c --\ "winssb_run_from_tray").as[ Boolean]
two_factor_auth_enabled<-(c --\ "two_factor_auth_enabled").as[ Boolean]
two_factor_type<-(c --\ "two_factor_type").as[ String] //null (object)]
mentions_exclude_at_channels<-(c --\ "mentions_exclude_at_channels").as[ Boolean]
confirm_clear_all_unreads<-(c --\ "confirm_clear_all_unreads").as[ Boolean]
confirm_user_marked_away<-(c --\ "confirm_user_marked_away").as[ Boolean]
box_enabled<-(c --\ "box_enabled").as[ Boolean]
seen_single_emoji_msg<-(c --\ "seen_single_emoji_msg").as[ Boolean]
confirm_sh_call_start<-(c --\ "confirm_sh_call_start").as[ Boolean] 
  } yield SelfPrefs(
 highlight_words,
user_colors,
color_names_in_list,
growls_enabled,
tz,
push_dm_alert,
push_mention_alert,
push_everything,
push_idle_wait,
push_sound,
push_loud_channels,
push_mention_channels,
push_loud_channels_set,
email_alerts,
email_alerts_sleep_until,
email_misc,
email_weekly,
welcome_message_hidden,
all_channels_loud,
loud_channels,
never_channels,
loud_channels_set,
show_member_presence,
search_sort,
expand_inline_imgs,
expand_internal_inline_imgs,
expand_snippets,
posts_formatting_guide,
seen_welcome_2,
seen_ssb_prompt,
seen_spaces_new_xp_tooltip,
spaces_new_xp_banner_dismissed,
search_only_my_channels,
emoji_mode,
emoji_use,
has_invited,
has_uploaded,
has_created_channel,
search_exclude_channels,
messages_theme,
webapp_spellcheck,
no_joined_overlays,
no_created_overlays,
dropbox_enabled,
seen_domain_invite_reminder,
seen_member_invite_reminder,
mute_sounds,
arrow_history,
tab_ui_return_selects,
obey_inline_img_limit,
new_msg_snd,
collapsible,
collapsible_by_click,
require_at,
ssb_space_window,
mac_ssb_bounce,
mac_ssb_bullet,
expand_non_media_attachments,
show_typing,
pagekeys_handled,
last_snippet_type,
display_real_names_override,
time24,
enter_is_special_in_tbt,
graphic_emoticons,
convert_emoticons,
autoplay_chat_sounds,
ss_emojis,
sidebar_behavior,
seen_onboarding_start,
onboarding_cancelled,
seen_onboarding_slackbot_conversation,
seen_onboarding_channels,
seen_onboarding_direct_messages,
seen_onboarding_invites,
seen_onboarding_search,
seen_onboarding_recent_mentions,
seen_onboarding_starred_items,
seen_onboarding_private_groups,
onboarding_slackbot_conversation_step,
mark_msgs_read_immediately,
start_scroll_at_oldest,
snippet_editor_wrap_long_lines,
ls_disabled,
sidebar_theme,
sidebar_theme_custom_values,
f_key_search,
k_key_omnibox,
speak_growls,
mac_speak_voice,
mac_speak_speed,
comma_key_prefs,
at_channel_suppressed_channels,
push_at_channel_suppressed_channels,
prompted_for_email_disabling,
full_text_extracts,
no_text_in_notifications,
muted_channels,
no_macssb1_banner,
no_winssb1_banner,
no_omnibox_in_channels,
k_key_omnibox_auto_hide_count,
privacy_policy_seen,
search_exclude_bots,
fuzzy_matching,
load_lato_2,
fuller_timestamps,
last_seen_at_channel_warning,
flex_resize_window,
msg_preview,
msg_preview_displaces,
msg_preview_persistent,
emoji_autocomplete_big,
winssb_run_from_tray,
two_factor_auth_enabled,
two_factor_type,
mentions_exclude_at_channels,
confirm_clear_all_unreads,
confirm_user_marked_away,
box_enabled,
seen_single_emoji_msg,
confirm_sh_call_start 
  ))
}
*/