-- These stack top pointers are used when allocating new track lines and tracks
-- Track line stack top pointer
local track_line_top = {value = 0}
-- Stack top pointer for tracks within static track line
local static_track_top = {value = 0}
-- Stack top pointer for tracks within blending track line
local blending_track_top = {value = 0}
-- Function to increment a stack top pointer, used to allocate new track lines or tracks
local function increment(obj)
    obj.value = obj.value + 1
    return obj.value - 1
end

-- Static track line and its five tracks
local STATIC_TRACK_LINE = increment(track_line_top)
local BASE_TRACK = increment(static_track_top)
local BOLT_CAUGHT_TRACK = increment(static_track_top)
local SAFETY_TRACK = increment(static_track_top) -- To be implemented
local ADS_TRACK = increment(static_track_top) -- To be implemented
local MAIN_TRACK = increment(static_track_top)

-- Track line for firing
local GUN_KICK_TRACK_LINE = increment(track_line_top)

-- Blending track line and its two tracks, used for layered animations like running/walking/jumping
-- LOOP_TRACK is defined but not used yet, so its purpose is currently unknown
local BLENDING_TRACK_LINE = increment(track_line_top)
local MOVEMENT_TRACK = increment(blending_track_top)
local LOOP_TRACK = increment(blending_track_top)

-- Method to play the "put away gun" animation
local function runPutAwayAnimation(context)
    local put_away_time = context:getPutAwayTime()
    -- Retrieves the MAIN_TRACK from STATIC_TRACK_LINE
    local track = context:getTrack(STATIC_TRACK_LINE, MAIN_TRACK)
    -- Plays the put_away animation with transition time of put_away_time * 0.75
    context:runAnimation("put_away", track, false, PLAY_ONCE_HOLD, put_away_time * 0.75)
    -- Sets animation progress to the last frame
    context:setAnimationProgress(track, 1, true)
    -- Adjusts animation progress backwards by put_away_time
    context:adjustAnimationProgress(track, -put_away_time, false)
end

-- Checks if there is no ammo left
local function isNoAmmo(context)
    -- Checks both the barrel and the magazine
    return (not context:hasBulletInBarrel()) and (context:getAmmoCount() <= 0)
end

-- Method to play the reload animation
local function runReloadAnimation(context)
    local track = context:getTrack(STATIC_TRACK_LINE, MAIN_TRACK)
    local ext = context:getMagExtentLevel()
    -- Choose between tactical reload or empty reload depending on ammo
    if (isNoAmmo(context)) then
        if (ext == 0) then
            context:runAnimation("reload_empty", track, false, PLAY_ONCE_STOP, 0.2)
        elseif (ext == 1) then
            context:runAnimation("reload_empty_xmag2", track, false, PLAY_ONCE_STOP, 0.2)
        elseif (ext == 2 or ext == 3) then
            context:runAnimation("reload_empty_xmag3", track, false, PLAY_ONCE_STOP, 0.2)
        else
            context:runAnimation("reload_empty", track, false, PLAY_ONCE_STOP, 0.2)
        end
    else
        if (ext == 0) then
            context:runAnimation("reload_tactical", track, false, PLAY_ONCE_STOP, 0.2)
        elseif (ext == 1) then
            context:runAnimation("reload_norm_xmag2", track, false, PLAY_ONCE_STOP, 0.2)
        elseif (ext == 2 or ext == 3) then
            context:runAnimation("reload_norm_xmag3", track, false, PLAY_ONCE_STOP, 0.2)
        else
            context:runAnimation("reload_tactical", track, false, PLAY_ONCE_STOP, 0.2)
        end
    end
end

-- Method to play the inspect animation
local function runInspectAnimation(context)
    local track = context:getTrack(STATIC_TRACK_LINE, MAIN_TRACK)
    local ext = context:getMagExtentLevel()
    -- Choose between normal or empty inspect based on ammo
    if (isNoAmmo(context)) then
        if (ext == 0) then
            context:runAnimation("inspect_empty", track, false, PLAY_ONCE_STOP, 0.2)
        elseif (ext == 1) then
            context:runAnimation("inspect_empty_xmag2", track, false, PLAY_ONCE_STOP, 0.2)
        elseif (ext == 2 or ext == 3) then
            context:runAnimation("inspect_empty_xmag3", track, false, PLAY_ONCE_STOP, 0.2)
        else
            context:runAnimation("inspect_empty", track, false, PLAY_ONCE_STOP, 0.2)
        end
    else
        if (ext == 0) then
            context:runAnimation("inspect", track, false, PLAY_ONCE_STOP, 0.2)
        elseif (ext == 1) then
            context:runAnimation("inspect_xmag2", track, false, PLAY_ONCE_STOP, 0.2)
        elseif (ext == 2 or ext == 3) then
            context:runAnimation("inspect_xmag3", track, false, PLAY_ONCE_STOP, 0.2)
        else
            context:runAnimation("inspect", track, false, PLAY_ONCE_STOP, 0.2)
        end
    end
end

-- State on the base track, loops the static_idle animation
local base_track_state = {}

-- Enters the base state, directly plays static_idle
function base_track_state.entry(this, context)
    context:runAnimation("static_idle", context:getTrack(STATIC_TRACK_LINE, BASE_TRACK), false, LOOP, 0)
end
