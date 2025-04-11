local M = {}

-- Helper function to check if there is no ammo
local function isNoAmmo(context)
    return (not context:hasBulletInBarrel()) and (context:getAmmoCount() <= 0)
end

-- Function to start the reload animation based on ammo count
function M.start_reload(api)
    local ammo = api:getAmmoCount()

    -- Get the track for the static track line (MAIN_TRACK)
    local track = api:getTrack(STATIC_TRACK_LINE, MAIN_TRACK)

    -- When mag is empty, play "reload_empty" animation
    if ammo == 0 then
        api:playAnimation("reload_empty", track, false, PLAY_ONCE_STOP, 0.2)
    elseif ammo == 1 then
        api:playAnimation("reload_1", track, false, PLAY_ONCE_STOP, 0.2)
    elseif ammo == 2 then
        api:playAnimation("reload_2", track, false, PLAY_ONCE_STOP, 0.2)
    elseif ammo == 3 then
        api:playAnimation("reload_3", track, false, PLAY_ONCE_STOP, 0.2)
    elseif ammo == 4 then
        api:playAnimation("reload_4", track, false, PLAY_ONCE_STOP, 0.2)
    else
        api:playAnimation("reload", track, false, PLAY_ONCE_STOP, 0.2)  -- fallback reload
    end
    return true
end

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

-- Method to play the inspect animation
local function runInspectAnimation(context)
    local track = context:getTrack(STATIC_TRACK_LINE, MAIN_TRACK)
    local ext = context:getMagExtentLevel()
    -- Choose between normal or empty inspect based on ammo
    if (isNoAmmo(context)) then
        context:runAnimation("inspect_empty", track, false, PLAY_ONCE_STOP, 0.2)
    else
        context:runAnimation("inspect", track, false, PLAY_ONCE_STOP, 0.2)
    end
end

-- State on the base track, loops the static_idle animation
local base_track_state = {}

-- Enters the base state, directly plays static_idle
function base_track_state.entry(this, context)
    context:runAnimation("static_idle", context:getTrack(STATIC_TRACK_LINE, BASE_TRACK), false, LOOP, 0)
end

return M
